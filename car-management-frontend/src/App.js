// import React, { useState } from 'react';
// import SignUp from './components/SignUp';
// import Login from './components/Login';
// import CarList from './components/CarList';
// import AddCar from './components/AddCar';
// import About from './components/About';
// import './styles/App.css';

// const App = () => {
//     const [userId, setUserId] = useState(null); // Store logged-in user ID
//     const [activePage, setActivePage] = useState('about'); // Track active page

//     const handleLogin = (id) => {
//         setUserId(id); // Set userId when a user logs in
//     };

//     return (
//         <div>
//             <header className="navbar">
//                 <h1>Car Management App</h1>
//                 <nav>
//                     <button onClick={() => setActivePage('about')}>About Us</button>
//                     <button onClick={() => setActivePage('signup')}>Sign Up</button>
//                     <button onClick={() => setActivePage('login')}>Login</button>
//                     <button onClick={() => setActivePage('your-cars')}>Your Cars</button>
//                     <button onClick={() => setActivePage('add-car')}>Add Car</button>
//                 </nav>
//             </header>

//             <main className="content">
//                 {activePage === 'about' && <About />}
//                 {activePage === 'signup' && <SignUp />}
//                 {activePage === 'login' && <Login onLogin={handleLogin} />}
//                 {activePage === 'your-cars' &&
//                     (userId ? <CarList userId={userId} /> : <p>Please log in to view your cars.</p>)}
//                 {activePage === 'add-car' &&
//                     (userId ? <AddCar userId={userId} /> : <p>Please log in to add a car.</p>)}
//             </main>
//         </div>
//     );
// };

// export default App;

import React, { useState } from 'react';
import SignUp from './components/SignUp';
import Login from './components/Login';
import CarList from './components/CarList';
import AddCar from './components/AddCar';
import About from './components/About';
import SearchCars from './components/SearchCars'; // Import the SearchCars component

const App = () => {
    const [userId, setUserId] = useState(null); // Store logged-in user ID
    const [activePage, setActivePage] = useState('about'); // Track active page

    const handleLogin = (id) => {
        setUserId(id); // Set userId when a user logs in
    };

    return (
        <div>
            <header className="navbar">
                <h1>Car Management App</h1>
                <nav>
                    <button onClick={() => setActivePage('about')}>About Us</button>
                    <button onClick={() => setActivePage('signup')}>Sign Up</button>
                    <button onClick={() => setActivePage('login')}>Login</button>
                    <button onClick={() => setActivePage('your-cars')}>Your Cars</button>
                    <button onClick={() => setActivePage('add-car')}>Add Car</button>
                    <button onClick={() => setActivePage('search-cars')}>Search Cars</button> {/* New button */}
                </nav>
            </header>

            <main className="content">
                {activePage === 'about' && <About />}
                {activePage === 'signup' && <SignUp />}
                {activePage === 'login' && <Login onLogin={handleLogin} />}
                {activePage === 'your-cars' &&
                    (userId ? <CarList userId={userId} /> : <p>Please log in to view your cars.</p>)}
                {activePage === 'add-car' &&
                    (userId ? <AddCar userId={userId} /> : <p>Please log in to add a car.</p>)}
                {activePage === 'search-cars' && <SearchCars />} {/* Render SearchCars */}
            </main>
        </div>
    );
};

export default App;
