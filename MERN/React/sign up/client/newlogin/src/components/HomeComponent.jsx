import React, { useState } from 'react';

const HomeComponent = (props) => {
    const [username, setUsername] = useState("");
    const [usernameError, setUsernameError] = useState("");

    const [email, setEmail] = useState("");
    const [emailError, setEmailError] = useState("");

    const [password, setPassword] = useState("");
    const [passwordError, setPasswordError] = useState("");




    const handleusername = (e) => {
        setUsername(e.target.value);
        if (e.target.value.length < 1) {
            setUsernameError("username is required!");
        } else if (e.target.value.length < 3) {
            setUsernameError("username must be 3 characters or longer!");
        } else {
            setUsernameError("");
        }
    };

    const handleemail = (e) => {
        setEmail(e.target.value);
        if (e.target.value.length < 1) {
            setEmailError("email is required!");
        } else if (e.target.value.length < 5) {
            setEmailError("email must be 5 characters or longer!");
        } else {
            setEmailError("");
        }
    };

    const handlepassword = (e) => {
        setPassword(e.target.value);
        if (e.target.value.length < 1) {
            setPasswordError("password is required!");
        } else if (e.target.value.length < 6) {
            setPasswordError("password must be 6 characters or longer!");
        } else {
            setPasswordError("");
        }
    };

    const createUser = (e) => {
        e.preventDefault();
        const newUser = { username, email, password };
        props.onUserSubmit(newUser);
        console.log("Welcome", newUser);

        setUsername("");
        setEmail("");
        setPassword("");
    };

    return (
        <form onSubmit={createUser}>
            <div>
                <label>Username: </label>
                <input type="text" value={username} onChange={handleusername} />
                {usernameError ? <p>{usernameError}</p> : ""}
            </div>

            <div>
                <label>Email Address: </label>
                <input type="text" value={email} onChange={handleemail} />
                {emailError ? <p>{emailError}</p> : ""}
            </div>

            <div>
                <label>Password: </label>
                <input type="text" value={password} onChange={handlepassword} />
                {passwordError ? <p>{passwordError}</p> : ""}
            </div>

            {usernameError || emailError || passwordError || !username || !email || !password ? (
                <input type="submit" value="Create User" disabled />
            ) : (
                <input type="submit" value="Create User" />
            )}
        </form>
    );
};

export default HomeComponent;
