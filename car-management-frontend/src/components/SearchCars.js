// import React, { useState } from 'react';
// import { searchCars } from '../services/api'; // Corrected import path

// const SearchCars = () => {
//     const [query, setQuery] = useState('');
//     const [results, setResults] = useState([]);

//     const handleSearch = async () => {
//         try {
//             const response = await searchCars(query);
//             setResults(response);
//         } catch (error) {
//             console.error('Error searching cars:', error);
//         }
//     };

//     return (
//         <div>
//             <h2>Search Cars</h2>
//             <input
//                 type="text"
//                 value={query}
//                 onChange={(e) => setQuery(e.target.value)}
//                 placeholder="Search by title, description, or tags"
//             />
//             <button onClick={handleSearch}>Search</button>

//             <div>
//                 {results.length > 0 ? (
//                     <ul>
//                         {results.map((car) => (
//                             <li key={car.id}>
//                                 <h3>{car.title}</h3>
//                                 <p>{car.description}</p>
//                                 <p><strong>Tags:</strong> {car.tags}</p>
//                             </li>
//                         ))}
//                     </ul>
//                 ) : (
//                     <p>No cars found.</p>
//                 )}
//             </div>
//         </div>
//     );
// };

// export default SearchCars;



import React, { useState } from 'react';
import { searchCars, deleteCar } from '../services/api'; // Include deleteCar function

const SearchCars = () => {
    const [query, setQuery] = useState('');
    const [results, setResults] = useState([]);

    const handleSearch = async () => {
        try {
            const response = await searchCars(query);
            setResults(response);
        } catch (error) {
            console.error('Error searching cars:', error);
        }
    };

    const handleDelete = async (carId) => {
        try {
            // Call deleteCar API
            await deleteCar(carId);
            // Remove the deleted car from the results
            setResults(results.filter((car) => car.id !== carId));
            alert('Car deleted successfully!');
        } catch (error) {
            console.error('Error deleting car:', error);
            alert('Failed to delete car.');
        }
    };

    return (
        <div>
            <h2>Search Cars</h2>
            <input
                type="text"
                value={query}
                onChange={(e) => setQuery(e.target.value)}
                placeholder="Search by title, description, or tags"
            />
            <button onClick={handleSearch}>Search</button>

            <div>
                {results.length > 0 ? (
                    <ul>
                        {results.map((car) => (
                            <li key={car.id}>
                                <h3>{car.title}</h3>
                                <p>{car.description}</p>
                                <p><strong>Tags:</strong> {car.tags}</p>
                                <button
                                    onClick={() => handleDelete(car.id)}
                                    style={{
                                        backgroundColor: 'red',
                                        color: 'white',
                                        border: 'none',
                                        padding: '5px 10px',
                                        cursor: 'pointer',
                                    }}
                                >
                                    Delete
                                </button>
                            </li>
                        ))}
                    </ul>
                ) : (
                    <p>No cars found.</p>
                )}
            </div>
        </div>
    );
};

export default SearchCars;
