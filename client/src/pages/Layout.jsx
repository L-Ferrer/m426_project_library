import { Outlet } from "react-router-dom";

const Layout = () => {
  return (
    <>
      <nav>
        <a className="navlink" href="/">Library</a>
        <a className="navlink" id="logout" href="/logout">Logout</a>
      </nav>

      <Outlet />
    </>
  )
};

export default Layout;