import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

import './include/bootstrap';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import { AppNav } from './Components/AppNav';
import { newReimbursementComponent } from './Components/newReimbursementComponent';
import { homeComponent } from './Components/homeComponent';
import { viewReimbursementComponent } from './Components/viewReimbursementComponent';
import { viewMyReimbursementComponent } from './Components/viewMyReimbursementComponent';
import { SignInComponent } from './Components/SignInComponent';
import { viewReimbursementByIdComponent } from './Components/viewReimbursementByIdComponent';
import { viewReimbursementByStatusComponent } from './Components/viewReimbursementByStatusComponent';
import { viewReimbursementByAuthorComponent } from './Components/viewReimbursementByAuthorComponent';
import { ReimbursementTableComponent } from './Components/ReimbursementTableComponent';
import { resolveReimbursementComponent } from './Components/ResolveReimbursementComponent';
//import { viewReimbursementComponent} from './Components/viewReimbursementComponent';


class App extends Component {

  render() {
    return (


      <BrowserRouter>
        <>
          <AppNav />
          <div id="main_content_containter">
            <Switch>
              <Route path="/home" component={SignInComponent} />
              <Route path="/sign-in" component={SignInComponent} />
              <Route path="/newReimb" component={newReimbursementComponent} />
              {/* <Route path="/viewReimb" component={viewReimbursementComponent} /> */}
              <Route path="/viewReimb" component={viewReimbursementComponent} /> {/*This is for testing. Remember to change this back later */}
              <Route path="/myReimb" component={viewMyReimbursementComponent} />
              <Route path="/idReimb" component={viewReimbursementByIdComponent} />
              <Route path="/statusReimb" component={viewReimbursementByStatusComponent} />
              <Route path="/authorReimb" component={viewMyReimbursementComponent} />
              <Route path="/resolveReimb" component={resolveReimbursementComponent} />
              {/* /myReimb, /idReimb, /statusReimb, /authorReimb do not have a navbar listing because 
            they will be accessed within the viewReimb page */}
            </Switch>
          </div>
        </>
      </BrowserRouter>
    );
  }
}

export default App;
