import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const BoardWrite = () => {
  const navigate = useNavigate();

  const [board, setBoard] = useState({
    title: '',
    createdBy: '',
    contents: ''
  });

  const {title, createdBy, contents} = board;

  const onChange = (event) => {
    const {value, name} = event.target;
    setBoard({
      ...board,
      [name]: value,
    });
  }
};

export default BoardWrite;