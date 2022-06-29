import { useState, useEffect } from "react";
import useToken from '../useToken';
import Login from "./Login";

function Dashboard() {
    const [data, setData] = useState([]);
    const { token, setToken } = useToken();
    const [ user, setUser ] = useState();
    if(!token){
        console.warn('No token found');
        console.log("Token: " + token);
        return <Login setToken={setToken} />
    }
    useEffect(() => {
        setUser(localStorage.getItem('user'));
        fetch('http://localhost:8080/user/login/auth', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          }
        })
          .then(data => setData(data));
    }, []);

    return (
        <>
            <div id="user">Currently logged in as:&nbsp;&nbsp;<b>{user}</b></div>
            <div className="content">
                <h1>Library</h1>
            </div>
        </>
    )
};
export default Dashboard;