import { useState, useEffect } from "react";
import '../styles/login.css'
import '../App.css'

function Register() {
    // React States
    const [errorMessages, setErrorMessages] = useState({});
    const [isSubmitted, setIsSubmitted] = useState(false);
    const [email, setEmail] = useState();
    const [username, setUserName] = useState();
    const [pass, setPass] = useState();
    const error = "invalid username or password";


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

    const getKeep = () => {
        const keep = sessionStorage.getItem('keep');
        return keep;
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

    // JSX code for login form
    const renderForm = (
        <div className="form">
            <form onSubmit={handleSubmit}>
                <div className="input-container">
                    <label>Email </label>
                    <input type="text" name="email" required onChange={e => setEmail(e.target.value)} />
                </div>
                <div className="input-container">
                    <label>Username </label>
                    <input type="text" name="uname" required onChange={e => setUserName(e.target.value)} />
                </div>
                <div className="input-container">
                    <label>Password </label>
                    <input type="password" name="pass" required onChange={e => setPass(e.target.value)} />
                    {renderErrorMessage("error")}
                </div>
                <div className="button-container">
                    <input type="submit" value="Login" />
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

    return ( 
        <>
            <div className="main">
                <h1>Register</h1>
                <div className="login-form">
                    <div className="title">Sign Up</div>
                    {isSubmitted ? <div>User is successfully logged in</div> : renderForm}
                </div>
            </div>
        </>
    )
};

export default Register;