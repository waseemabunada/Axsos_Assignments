import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Register from './components/Register'; 
function App() {
  const [count, setCount] = useState(0)

  return (
    <>
  <div className="App">
      <h1>Register</h1>
      <Register/>
    </div>
</>
  );
}
export default App
