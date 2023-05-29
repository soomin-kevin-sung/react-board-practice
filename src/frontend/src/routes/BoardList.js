import React, {useEffect, useState} from 'react';
import axios from "axios";
import {Link} from 'react-router-dom';

const BoardList = () => {
  const [boardList, setBoardList] = useState([]);

  const getBoardList = async () => {
    const resp = await (await axios.get('/api/board')).data;
    setBoardList(resp.data);

    const pngn = resp.pagination;
    console.log(pngn);
  }

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
    </div>
  );
};

export default BoardList;