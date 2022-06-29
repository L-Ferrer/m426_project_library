import { useState, useEffect } from "react";
import '../App.css';
import PropTypes from 'prop-types';

function Login({setToken}) {
    const [errorMessages, setErrorMessages] = useState({});
    const [isSubmitted, setIsSubmitted] = useState(false);
    const [username, setUserName] = useState();
    const [pass, setPass] = useState();
    const [keep, setKeep] = useState();
    const error = "invalid username or password";

    useEffect(() => {
        setKeep(false);
    }, []);

    async function loginUser(credentials) {
        return fetch('http://localhost:8080/user/login/auth', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(credentials)
        })
          .then(data => data.json());
    }

    const handleSubmit = async e => {
        e.preventDefault();
        sessionStorage.setItem('keep', JSON.stringify(keep));
        let password = await sha256(pass);
        const res = await loginUser({
            username,
            password
          });
          if (res.token) {
            console.log("Login success")
            setIsSubmitted(true);
            setToken(res.token);
            localStorage.setItem('user', res.username);
            if(keep == true){
                localStorage.setItem('token', res.token);
            }
          }else{
            setErrorMessages({ name: "error", message: error });
          }
    };

    // Generate JSX code for error message
    const renderErrorMessage = () => (
        <div className="error">{errorMessages.message}</div>
    );

    function checkKeep() {
        if(document.getElementById("keep").checked){
            return true;
        }else{
            return false;
        }
    }

    // JSX code for login form
    const renderForm = (
        <div className="form">
            <form onSubmit={handleSubmit}>
                <div className="input-container">
                    <label>Username </label>
                    <input type="text" name="uname" required onChange={e => setUserName(e.target.value)} />
                </div>
                <div className="input-container">
                    <label>Password </label>
                    <input type="password" name="pass" required onChange={e => setPass(e.target.value)} />
                    {renderErrorMessage("error")}
                </div>
                <div className="input-checkbox">
                    <label><input type="checkbox" id="keep" value="true" onChange={() => setKeep(checkKeep())} />Keep me logged in </label>
                </div>
                <div className="button-container">
                    <input type="submit" value="Login" />
                </div>
                <div className="register-link-container">
                    <a className="register-link" href="/register">Create a new account</a>
                </div>
            </form>
        </div>
    );

    async function sha256(message) {
        // encode as UTF-8
        const msgBuffer = new TextEncoder('utf-8').encode(message);
      
        // hash the message
        const hashBuffer = await crypto.subtle.digest('SHA-256', msgBuffer);
      
        // convert ArrayBuffer to Array
        const hashArray = Array.from(new Uint8Array(hashBuffer));
      
        // convert bytes to hex string
        const hashHex = hashArray.map(b => ('00' + b.toString(16)).slice(-2)).join('');
        return hashHex;
    }

    Login.propTypes = {
    setToken: PropTypes.func.isRequired
    }
    
    return ( 
        <>
            <div className="main">
                <h1>Login</h1>
                <div className="login-form">
                    <div className="title">Sign In</div>
                    {isSubmitted ? <div>User is successfully logged in</div> : renderForm}
                </div>
            </div>
        </>
    )
};

export default Login;