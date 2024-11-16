import React from 'react';
import '../styles/About.css';

const About = () => {
    return (
        <div className="about">
            <h2>Welcome to the Car Management App!</h2>
            <p>
                Manage your cars effortlessly with our app. Add details, upload images, and
                search through your cars with ease. Designed to make your life simpler.
            </p>
            <div className="about-images">
                <img src="car1.jpg" alt="Car 1" />
                <img src="car2.jpg" alt="Car 2" />
                <img src="car3.jpg" alt="Car 3" />
            </div>
        </div>
    );
};

export default About;
