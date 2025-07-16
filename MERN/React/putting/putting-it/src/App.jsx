import React,{ useState } from 'react'
import './App.css'
import PersonCard from './components/PersonCard'
function App() {
  const [count, setCount] = useState(0)

  return (
    <>

    <PersonCard firstname="Jane" lastname="Doe" age={45} haircolour="Black"/> 
    <PersonCard firstname="Smith" lastname="John" age={88} haircolour="brown"/>
      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
        <p>
          Edit <code>src/App.jsx</code> and save to test HMR
        </p>
      </div>
      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>
    </>
  )
}

export default App
