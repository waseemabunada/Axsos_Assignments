import React ,{useState}from "react";

const PersonCard=(props)=>{


const {firstname,lastname,age,haircolour}=props
const [myAge,setMyAge]=useState(age)
 return(
    
    <>
    <h1>{lastname},{firstname} </h1>
    <h6>Age:{myAge}</h6>
    <h6>Hair color: {haircolour}</h6>
    <button onClick={() => setMyAge((myAge) => myAge + 2)}>
         Birthday for {firstname}  
        </button>

        <button onClick={() => setMyAge((myAge) => age )}>
         Reset {firstname}  
        </button>
    </>
    )

}


export default PersonCard;