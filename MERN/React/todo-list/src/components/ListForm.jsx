import React, { useState, useEffect } from 'react'

const ListForm = (props) => {
    const [task, setTask] = useState("")
    const [error, setError] = useState(" ")
    const [newTask, setNewTask] = useState(false)

    function isValidTask(value) {
        return value.length >= 5 ? true : false;
    }

    const checkTask = (e) => {
        setNewTask(false) 
        if (isValidTask(e.target.value)) {
            setError("");
            setTask(e.target.value)
        } else {
            setError("Error: the task should be at least 5 characters")
        }
    }


    const handleSumbit = (e) => {
        e.preventDefault()
        if (!error) {

            props.addTask(task)
            setNewTask(true)
            setError(" ")
        } else {
            setError("Error: the task should be at least 5 characters")
        }
    }

    return (
        <>
            <h2>Add new task</h2>
            <form onSubmit={handleSumbit}>
                <input className='form-control' type='text' onChange={checkTask} value={newTask ? "" : undefined} />
                <p className='text-danger'><small>{error}</small></p>
                <input className='btn btn-info' type='submit' value="Add"></input>
            </form>
        </>
    )
}

export default ListForm