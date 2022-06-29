import { useState } from 'react';

export default function useToken() {
    const getToken = () => {
      const tokenString = sessionStorage.getItem('token');
      return tokenString
    };
  
    const [token, setToken] = useState(getToken());
  
    const saveToken = tokenString => {
      sessionStorage.setItem('token', JSON.stringify(tokenString));
      setToken(tokenString);
    };
  
    return {
      setToken: saveToken,
      token
    }
  }