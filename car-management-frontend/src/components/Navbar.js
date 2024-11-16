import React from 'react';
import '../styles/Navbar.css';

const Navbar = () => {
  return (
    <div className="navbar">
      <h1>Car Management App</h1>
      <div>
        <a href="/signup">Sign Up</a>
        <a href="/login">Login</a>
        <a href="/cars">Your Cars</a>
        <a href="/add-car">Add Car</a>
      </div>
    </div>
  );
};

export default Navbar;
