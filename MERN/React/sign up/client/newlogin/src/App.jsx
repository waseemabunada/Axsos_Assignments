import React, { useState } from 'react';
import './App.css';
import HomeComponent from './components/HomeComponent';
import MainComponent from './components/MainComponent';

function App() {
    const [users, setUsers] = useState([]);

    const handleUserSubmit = (newUser) => {
        setUsers([...users, newUser]);
    };

    return (
        <div>
            <h1>Sign Up</h1>
            <HomeComponent onUserSubmit={handleUserSubmit} />
            <MainComponent users={users} />
        </div>
    );
}

export default App;
