import { useState } from "react";
import logo from './logo.svg'
import './App.css'
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Layout from "./pages/Layout";
import Dashboard from "./pages/Dashboard";
import useToken from './useToken';

function App() {
  const { token, setToken } = useToken();
  if(!token){
    console.warn('No token found');
    console.log("Token: " + token);
    return <Login setToken={setToken} />
  }

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Dashboard />} />
          <Route path="login" element={<Login />} />
          <Route path="register" element={<Register />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App
