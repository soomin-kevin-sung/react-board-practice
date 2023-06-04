import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom"

const BoardUpdate = () => {
  const navigate = useNavigate();
  const { idx } = useParams();
  const [board, setBoard] = useState({
    idx: 0,
    title: '',
    createdBy: '',
    contents: '',
  });

  const { title, createdBy, contents } = board;

  const onChange = (event) => {
    const { value, name } = event.target;
    setBoard({
      ...board,
      [name]: value,
    });
  };

  const getBoard = async () => {
    const resp = await (await axios.get(`/api/board/${idx}`)).data;
    setBoard(resp.data);
  };

  const updateBoard = async () => {
    await axios.patch(`/api/board`, board).then((res) => {
      alert('수정되었습니다.');
      navigate('/board/' + idx);
    });
  };

  const backToDetail = () => {
    navigate('/board/' + idx);
  };

  useEffect(() => {
    getBoard();
  }, []);

  return (
    <div>
      <div>
        <span>제목</span>
        <input type="text" name="title" value={title} onChange={onChange}/>
      </div>
      <br/>
      <div>
        <span>작성자</span>
        <input type="text" name="createdBy" value={createdBy} readOnly={true}/>
      </div>
      <br/>
      <div>
        <span>내용</span>
        <textarea
          name="contents"
          cols="30"
          rows="10"
          value={contents}
          onChange={onChange}
        />
      </div>
      <br/>
      <div>
        <button onClick={updateBoard}>수정</button>
        <button onClick={backToDetail}>취소</button>
      </div>
    </div>
  );
}

export default BoardUpdate;