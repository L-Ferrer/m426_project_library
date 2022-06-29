import { useState } from 'react';

export default function useToken() {
    const getToken = () => {
      if(!sessionStorage.getItem('token')){
        return localStorage.getItem('token');
      } else{
        return sessionStorage.getItem('token');
      }
      
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