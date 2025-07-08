import React, { useState } from 'react'

const Body = (props) => {
  return (
    <div className='my-2 card'>
      {props.tabs.map((item, index) => (
        <React.Fragment key={index}>{item.active && <p>{item.content}</p>}</React.Fragment>
      ))
      }
    </div>
  )
}

export default Body