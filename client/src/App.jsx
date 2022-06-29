import { useState } from "react";
import logo from './logo.svg'
import './App.css'
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Layout from "./pages/Layout";
import Dashboard from "./pages/Dashboard";
import Logout from "./pages/Logout";
import useToken from './useToken';
import AddMedia from "./pages/AddMedia";

function App() {
  const { token, setToken } = useToken();

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Dashboard />} />
          <Route path="login" element={<Login setToken={setToken}/>} />
          <Route path="register" element={<Register />} />
          <Route path="logout" element={<Logout />} />
          <Route path="add/media" element={<AddMedia />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App
