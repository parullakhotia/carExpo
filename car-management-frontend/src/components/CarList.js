import React, { useEffect, useState } from 'react';
import { fetchCarsByUser } from '../services/api';

const CarList = ({ userId }) => {
    const [cars, setCars] = useState([]);

    useEffect(() => {
        const fetchCars = async () => {
            try {
                const data = await fetchCarsByUser(userId);
                setCars(data);
            } catch (error) {
                console.error(error);
                alert('Error fetching cars.');
            }
        };
        fetchCars();
    }, [userId]);

    return (
        <div>
            <h3>Your Cars</h3>
            {cars.map((car) => (
                <div key={car.id}>
                    <h4>{car.title}</h4>
                    <p>{car.description}</p>
                    <p>Tags: {car.tags}</p>
                </div>
            ))}
        </div>
    );
};

export default CarList;
