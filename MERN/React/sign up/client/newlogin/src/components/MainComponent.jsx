import React from 'react';

const MainComponent = ({ users }) => {
    return (
        <div>
            <h2>Registered Users:</h2>
            <ul>
                {users.map((user, index) => (
                    <li key={index}>
                        <strong>{user.username}</strong> - {user.email}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default MainComponent;
