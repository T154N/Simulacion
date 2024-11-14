import React, { useContext, useEffect } from 'react';
import { UserContext } from '../components/login/UserContext';
import './header.css';
import CMLogo from '../images/PedidoFlex Icons/CMDistribuidoraLogo.png';
import { useNavigate } from 'react-router-dom';
import { Carrito } from './carrito/Carrito';
import loginService from "../services/login/login.service";
import carrito from '../images/Header Icons/cart3.svg';
import informacion from '../images/Header Icons/info-circle.svg';
import usuario from '../images/Header Icons/person.svg';
import catalogo from '../images/Header Icons/catalogo.png';
import config from '../images/Header Icons/config.svg';
import { Offcanvas } from 'bootstrap';

export function Header() {
    const navigate = useNavigate();
    const { isLoggedIn, logout } = useContext(UserContext);

    useEffect(() => {
        const offcanvasElement = document.getElementById('offcanvasNavbar');
        const offcanvasInstance = Offcanvas.getInstance(offcanvasElement);

        const handleShow = () => {
            offcanvasElement.classList.add('bg-color');
        };

        const handleHide = () => {
            offcanvasElement.classList.remove('bg-color');
        };

        offcanvasElement.addEventListener('show.bs.offcanvas', handleShow);
        offcanvasElement.addEventListener('hide.bs.offcanvas', handleHide);

        return () => {
            offcanvasElement.removeEventListener('show.bs.offcanvas', handleShow);
            offcanvasElement.removeEventListener('hide.bs.offcanvas', handleHide);
        };
    }, []);

    const closeOffcanvasNavbar = () => {
        const offcanvasNavbarCloseButton = document.getElementById('offcanvasNavbarCloseButton');
        if (offcanvasNavbarCloseButton) {
            offcanvasNavbarCloseButton.click();
        }
    };

    const goToUserProfile = () => {
        navigate('/login');
        closeOffcanvasNavbar();
    };

    const goToCatalogue = () => {
        navigate('/catalogo');
        closeOffcanvasNavbar();
    };

    const goToInformacion = () => {
        navigate('/info');
        closeOffcanvasNavbar();
    };

    const goToHomePage = () => {
        navigate('/');
        closeOffcanvasNavbar();
    };

    const goToAdminConfig = () => {
        navigate('/inicioAdmin');
        closeOffcanvasNavbar();
    };

    const mostrarCarrito = () => {
        const offcanvasNavbarCloseButton = document.getElementById('offcanvasNavbarCloseButton');
        const offcanvasElement = document.getElementById('offcanvasScrolling');
        const offcanvasInstance = Offcanvas.getInstance(offcanvasElement);

        if (offcanvasNavbarCloseButton) {
            offcanvasNavbarCloseButton.click();
        }

        if (offcanvasInstance) {
            offcanvasInstance.show();
        }
    };

    const handleLogout = () => {
        loginService.cerrarSesion();
        logout();
        navigate('/');
        closeOffcanvasNavbar();
    };

    return (
        <div>
            <header>
                <nav className="navbar navbar-light navbar-expand-lg" style={{ backgroundColor: "#FCBB3A" }}>
                    <div className="d-flex justify-content-between w-100 ms-2 me-2">
                        <button className="btn logo-button">
                            <img src={CMLogo} style={{
                                width: "150px",
                                height: "auto",
                                marginRight: "3px",
                                verticalAlign: "middle",
                                outline: "none"
                            }} onClick={goToHomePage} alt="Logo"/>
                        </button>

                        <div className="d-flex align-items-center">
                            <button id="toggleOffcanvasButton" className="btn btn-header fs-5 d-lg-none"
                                    data-bs-toggle="offcanvas"
                                    data-bs-target="#offcanvasScrolling"
                                    aria-controls="offcanvasScrolling"
                                    onClick={mostrarCarrito}>
                                <img src={carrito} alt="Carrito" style={{
                                    width: "26px",
                                    height: "auto",
                                    marginRight: "3px",
                                    verticalAlign: "middle",
                                    padding: 0
                                }}/>
                                Carrito
                            </button>

                        <button className="navbar-toggler shadow-none border-0" type="button" data-bs-toggle="offcanvas"
                                data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
                            <span className="navbar-toggler-icon"></span>
                        </button>

                        </div>

                        <div className="sidebar offcanvas offcanvas-end custom-backdrop" tabIndex="-1"
                             id="offcanvasNavbar"
                             aria-labelledby="offcanvasNavbarLabel" data-bs-backdrop="false" inert>

                            <div className="offcanvas-header text-black">
                                <h5 className="offcanvas-title" id="offcanvasNavbarLabel">Menu de opciones</h5>
                                <button type="button" className="btn-close text-reset" data-bs-dismiss="offcanvas"
                                        aria-label="Close" id="offcanvasNavbarCloseButton"></button>
                            </div>
                            <div className="offcanvas-body">
                                <ul className="navbar-nav ms-auto justify-content-end flex-grow-1 text-start">
                                {loginService.esAdmin() &&
                                        <li className="nav-item me-1 mb-2">
                                            <div className="d-grid">
                                                <button className="btn btn-info fs-5" onClick={goToAdminConfig}>
                                                    <img src={config} alt="Carrito" style={{
                                                        width: "30px",
                                                        height: "auto",
                                                        marginRight: "3px",
                                                        verticalAlign: "middle",
                                                        padding: 0
                                                    }}/>
                                                    Administrador
                                                </button>
                                            </div>
                                        </li>}
                                    <li className="nav-item me-1 mb-2">
                                        <div className="d-grid">
                                            <button className="btn btn-header fs-5" onClick={goToCatalogue}>
                                                <img src={catalogo} alt="Catalogo" style={{
                                                    width: "30px",
                                                    height: "auto",
                                                    marginRight: "3px",
                                                    verticalAlign: "middle",
                                                    padding: 0
                                                }}/>
                                                Catalogo
                                            </button>
                                        </div>
                                    </li>
                                    <li className="nav-item me-1 mb-2 d-lg-block d-none">
                                        <div className="d-grid">
                                            <button className="btn btn-header fs-5"
                                                    data-bs-toggle="offcanvas"
                                                    data-bs-target="#offcanvasScrolling"
                                                    aria-controls="offcanvasScrolling"
                                                    onClick={mostrarCarrito}>
                                                <img src={carrito} alt="Carrito" style={{
                                                    width: "30px",
                                                    height: "auto",
                                                    marginRight: "3px",
                                                    verticalAlign: "middle",
                                                    padding: 0
                                                }}/>
                                                Carrito
                                            </button>
                                        </div>
                                    </li>
                                    <li className="nav-item me-1 mb-2">
                                        <div className="d-grid">
                                            <button className="btn btn-header fs-5" onClick={goToInformacion}>
                                                <img src={informacion} alt="Informacion" style={{
                                                    width: "30px",
                                                    height: "auto",
                                                    marginRight: "3px",
                                                    verticalAlign: "middle"
                                                }}/>
                                                Informacion
                                            </button>
                                        </div>
                                    </li>
                                    <li className="nav-item me-1 mb-2">
                                        <div className="d-grid">
                                            <button className="btn btn-header fs-5" onClick={isLoggedIn ? handleLogout : goToUserProfile}>
                                                <img src={usuario} alt="Login" style={{
                                                    width: "30px",
                                                    height: "auto",
                                                    marginRight: "3px",
                                                    verticalAlign: "middle"
                                                }}/>
                                                {isLoggedIn ? 'Cerrar sesión' : 'Login'}
                                            </button>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </nav>
            </header>
            <Carrito/>
        </div>
    );
}