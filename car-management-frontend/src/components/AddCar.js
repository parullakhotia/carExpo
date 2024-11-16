import React, { useState } from 'react';
import { addCar } from '../services/api'; // Import the API function

const AddCar = ({ userId }) => {
    const [carData, setCarData] = useState({
        title: '',       // Car title
        description: '', // Car description
        tags: ''         // Car tags
    });

    const [message, setMessage] = useState(''); // Message to show success or error feedback

    const handleSubmit = async (e) => {
        e.preventDefault(); // Prevent page reload on form submission

        if (!userId) {
            setMessage('Error: User not logged in.');
            console.error('User ID is missing.');
            return;
        }

        try {
            const newCar = await addCar(carData, userId); // Call the API with car data and user ID
            setMessage('Car added successfully!'); // Show success message
            console.log('Car added successfully:', newCar);

            // Clear form fields
            setCarData({ title: '', description: '', tags: '' });
        } catch (error) {
            setMessage('Failed to add car.'); // Show error message
            console.error('Failed to add car:', error);
        }
    };

    return (
        <div>
            <h2>Add a Car</h2>
            {message && <p>{message}</p>} {/* Display feedback message */}
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="Title"
                    value={carData.title}
                    onChange={(e) => setCarData({ ...carData, title: e.target.value })}
                    required
                />
                <textarea
                    placeholder="Description"
                    value={carData.description}
                    onChange={(e) => setCarData({ ...carData, description: e.target.value })}
                    required
                ></textarea>
                <input
                    type="text"
                    placeholder="Tags (comma-separated)"
                    value={carData.tags}
                    onChange={(e) => setCarData({ ...carData, tags: e.target.value })}
                />
                <button type="submit">Add Car</button>
            </form>
        </div>
    );
};

export default AddCar;
