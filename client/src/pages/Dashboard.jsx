import { useState } from "react";
import useToken from '../useToken';
import Login from "./Login";

function Dashboard() {
    const { token, setToken } = useToken();
    if(!token){
        console.warn('No token found');
        console.log("Token: " + token);
        return <Login setToken={setToken} />
    }

    return (
        <>
            <div id="logout">Logout</div>
            <div className="main">
                <h1>Dashboard</h1>
            </div>
        </>
    )
};
export default Dashboard;