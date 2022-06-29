import { Outlet } from "react-router-dom";

const Layout = () => {
  return (
    <>
      <nav>
        <th>
          <a className="navlink" href="/dashboard">Dashboard</a>
        </th>
      </nav>

      <Outlet />
    </>
  )
};

export default Layout;