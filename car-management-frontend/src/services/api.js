import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api'; // Base URL for the backend API

// User APIs
export const registerUser = async (userData) => {
    try {
        const response = await axios.post(`${BASE_URL}/users`, userData);
        return response.data;
    } catch (error) {
        console.error('Error registering user:', error);
        throw error;
    }
};

export const loginUser = async (username, password) => {
    try {
        const response = await axios.post(`${BASE_URL}/users/login`, { username, password });
        return response.data;
    } catch (error) {
        console.error('Error logging in user:', error);
        throw error;
    }
};

// Car APIs
export const fetchCarsByUser = async (userId) => {
    try {
        const response = await axios.get(`${BASE_URL}/cars?userId=${userId}`);
        return response.data;
    } catch (error) {
        console.error('Error fetching cars by user:', error);
        throw error;
    }
};

export const addCar = async (carData, userId) => {
    try {
        const response = await axios.post(`${BASE_URL}/cars?userId=${userId}`, carData);
        return response.data;
    } catch (error) {
        console.error('Error adding car:', error);
        throw error;
    }
};

export const updateCar = async (carId, updatedCarData) => {
    try {
        const response = await axios.put(`${BASE_URL}/cars/${carId}`, updatedCarData);
        return response.data;
    } catch (error) {
        console.error('Error updating car:', error);
        throw error;
    }
};

export const deleteCar = async (carId) => {
    try {
        const response = await axios.delete(`${BASE_URL}/cars/${carId}`);
        return response.data;
    } catch (error) {
        console.error('Error deleting car:', error);
        throw error;
    }
};

export const searchCars = async (keyword) => {
    try {
        const response = await axios.get(`${BASE_URL}/cars/search?keyword=${keyword}`);
        return response.data;
    } catch (error) {
        console.error('Error searching cars:', error);
        throw error;
    }
};
