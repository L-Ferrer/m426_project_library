import { useEffect } from "react";
import useToken from '../useToken';
import Login from "./Login";

function Dashboard() {
    const { token, setToken } = useToken();
    if(!token){
        console.warn('No token found');
        console.log("Token: " + token);
        return <Login setToken={setToken} />
    }

    useEffect(() => {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        sessionStorage.removeItem('token');
        window.location.href = "/login";
    }, []);


    return (
        <>
            <h2>Logging out...</h2>
        </>
    )
};
export default Dashboard;