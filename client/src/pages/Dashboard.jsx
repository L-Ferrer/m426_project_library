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
        fetch('http://localhost:8080/library', {
          method: 'GET'
        })
            .then(res => res.json())
            .then(data => setData(data))
            .catch((err) => console.error(err));
    }, []);

    return (
        <>
            <div id="user">Currently logged in as:&nbsp;&nbsp;<b>{user}</b></div>
            <div className="content">
                <h1 id="library-title">Library content</h1>
                <body class="large-screen">
                <div class="wrap">
                    <div class="table-wrapper">
                    <table class="table-responsive card-list-table">
                        <thead>
                        <tr>
                            <th>Title</th>
                            <th>Genre</th>
                            <th>Type</th>
                            <th>Year</th>
                            <th>Description</th>
                        </tr>
                        </thead>
                        <tbody>
                        {data.map((value, i) => (
                        <tr className="tableContent">
                            <td>{value.title}</td>
                            <td>{value.genre}</td>
                            <td>{value.type}</td>
                            <td>{value.year}</td>
                            <td>{value.info}</td>
                        </tr>
                         ))}
                        </tbody>
                    </table>
                    </div>
                </div>
                </body>
            </div>
            
        </>
    )
};
export default Dashboard;