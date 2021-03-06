import React from 'react';
import { Link } from 'react-router-dom';
// import RevLogo from '../Assets/rev-logo.png';
export class AppNav extends React.Component {
  render() {
    return (
      <div>
        <nav className="navbar navbar-toggleable-md navbar-expand-lg navbar-light bg-light display-front nav-pad">
          <div className="navbar-header c-pointer shift-left">
            <Link to="/home" className="unset-anchor">
              {/* <img className="img-adjust-position rev-logo" src={RevLogo} alt="revature" /> */}
            </Link>
          </div>
          <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarsExample04">
            <ul className="navbar-nav ml-auto margin-nav">
              <li className="nav-item active">
                <Link to="/home" className="unset-anchor nav-link">Home</Link>
              </li>
              <li className="nav-item active">
                <Link to="/sign-in" className="unset-anchor nav-link">Sign In</Link>
              </li>

              <li className="nav-item active dropdown">
              {/* <div className="nav-link nav-item dropdown-toggle pointer" id="reimbs-dropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Reimbursement Requests</div> */}
              {/* <div className="dropdown-menu dropdown-menu-right" aria-labelledby="reimbs-dropdown"> */}
                {/* <div className="dropdown-item"><Link to="/viewReimb" className="unset-anchor nav-link">View Reimbursement Requests</Link></div>
                <div className="dropdown-item"><Link to="/newReimb" className="unset-anchor nav-link">Create a New Request</Link></div> */}
                {/* <div className="dropdown-item"><Link to="/resolveReimb" className="Unset-anchor nav-link">Approve/Deny a Request</Link></div> */}
              {/* </div> */}
              </li>
            </ul>
          </div>
        </nav>
      </div >
    );
  }
}