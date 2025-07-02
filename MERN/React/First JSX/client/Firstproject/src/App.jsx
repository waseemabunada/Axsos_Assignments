import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <h1>Hello dojo</h1>
      <h3>things i need to do</h3>
      <ul>
        <li>learn react</li>
        <li>climb mt everist</li>
        <li>run A MARATHONFeed the dogs</li>
        <li>Feed the dogs</li>
      </ul>
    </>
  )
}

export default App
