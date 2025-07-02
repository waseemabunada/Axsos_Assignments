import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import PersonCard from './components/PersonCard';

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <PersonCard firstName="Wasem" lastName="Abu Nada"age={23}  hairColor="red" />
    <PersonCard firstName="Saher" lastName="Kawas"age={35}  hairColor="black" />
    <PersonCard firstName="Abood" lastName="Salhi"age={25}  hairColor="orange" />
    </>
  )
}

export default App
