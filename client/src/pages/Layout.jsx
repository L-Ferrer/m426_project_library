import { Outlet } from "react-router-dom";

const renderForm = (
  <nav>
    <a className="navlink" href="/">Library</a>
    <a className="navlink" id="logout" href="/logout">Logout</a>
    
  </nav>
);

const Layout = () => {
  return (
    <>
      {renderForm}
      <Outlet />
    </>
  )
};

export default Layout;