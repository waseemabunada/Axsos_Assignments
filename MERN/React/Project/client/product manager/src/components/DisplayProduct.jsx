import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams } from "react-router-dom";
import { Link } from 'react-router-dom';
import { useNavigate } from "react-router-dom";

const DisplayProduct = () => {
    const [product, setProduct] = useState({});
    const { id } = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        axios.get('http://localhost:8000/api/product/' + id)
            .then(res => setProduct(res.data))
            .catch(err => console.error(err));
    }, [id]);

    const deleteProduct = (id) => {
        axios.delete(`http://localhost:8000/api/product/${id}`)
            .then(() => {
                navigate("/"); 
            })
            .catch(err => console.error("Delete failed:", err));
    };

    return (
        <div>
            <p>Title: {product.title}</p>
            <p>Price: {product.price}</p>
            <p>Description: {product.description}</p>

            <Link to={`/product/edit/${id}`} className="btn btn-sm btn-outline-primary ms-2">
                Edit
            </Link>
            <button
                onClick={() => deleteProduct(product._id)}
                style={{
                    marginLeft: '10px',
                    color: 'white',
                    background: 'red',
                    border: 'none',
                    padding: '4px 8px',
                    borderRadius: '4px'
                }}
            >
                Delete
            </button>
        </div>
    );
};

export default DisplayProduct;