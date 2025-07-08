import React, { useState, useEffect } from 'react';

const Pokemon = () => {
    const [data, setData] = useState([]);
    const [show, setShow] = useState(false);

    useEffect(() => {
        fetch('https://pokeapi.co/api/v2/pokemon')
            .then((response) => response.json())
            .then((data) => setData(data.results))
            .catch((error) => console.error('Error fetching data:', error));
    }, []);

    const handleClick = () => {
        setShow(!show);
    };

    return (
        <>
            <button className="btn btn-danger p-5" onClick={handleClick}>
                Get Data
            </button>
            {show && (
                <ul className="list-group my-3 p-5">
                    {data.length > 0 &&
                        data.map((pokemonItem, index) => (
                            <li key={index} className="list-group-item">
                                {pokemonItem.name}
                            </li>
                        ))}
                </ul>
            )}
        </>
    );
};

export default Pokemon;
