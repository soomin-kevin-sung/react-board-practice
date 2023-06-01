import React, {useEffect, useState} from 'react';
import axios from "axios";
import {Link, useNavigate} from 'react-router-dom';

const BoardList = () => {
  const navigate = useNavigate();
  const [boardList, setBoardList] = useState([]);

  const getBoardList = async () => {
    const resp = await (await axios.get('/api/board')).data;
    setBoardList(resp.data);

    const pngn = resp.pagination;
    console.log(pngn);
  }

  const moveToWrite = () => {
    navigate('/write');
  };

  useEffect(() => {
    getBoardList();
  }, []);

  useEffect(() => console.log(boardList), [boardList]);

  return (
    <div>
      <ul>
        {boardList.map((board) => (
          <li key={board.idx}>
            <Link to={`/board/${board.idx}`}>{board.title}</Link>
          </li>
        ))}
      </ul>
      <div>
        <button onClick={moveToWrite}>글쓰기</button>
      </div>
    </div>
  );
};

export default BoardList;