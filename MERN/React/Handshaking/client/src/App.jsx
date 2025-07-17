import { useState, useEffect } from 'react'
import io from 'socket.io-client';

import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {

  const [socket] = useState(() => io(':8000'));
  const [message, setMessage] = useState('');

  useEffect(() => {
    // we need to set up all of our event listeners
    // in the useEffect callback function
    console.log('Is this running?');
    socket.on('Welcome', data => setMessage(data));

    // note that we're returning a callback function
    // this ensures that the underlying socket will be closed if App is unmounted
    // this would be more critical if we were creating the socket in a subcomponent
    return () => socket.removeAllListeners;
  }, [socket]);


  const sendMsg=(message)=>{
    socket.emit('event_from_client', message);

  }

  return (
    <>
      <div className="App">
        <h1>{message}</h1>
        <button onClick={()=>sendMsg('Hello from client!')}>Send Message</button>
      </div>
    </>
  )
}

export default App
