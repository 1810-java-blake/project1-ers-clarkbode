import React from 'react';
import App from '../App';

export class SignInComponent extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      username: '',
      password: '',
      //loggedIn: false,
      //User: 1
    }
  }

  passwordChange = (e) => {
    this.setState({
      ...this.state,
      password: e.target.value
    })
  }

  usernameChange = (e) => {
    this.setState({
      ...this.state,
      username: e.target.value
    })
  }

  submitEmployee = (e) => {
    e.preventDefault();
    let cred = this.state;
    fetch('http://localhost:8080/project1/users/login', {
      method: 'POST',
      body: JSON.stringify(cred),
      headers: {
        'Content-Type': 'application/json'
      },
      credentials: 'include'
    })
      .then(res => {
        
        if (res.status === 200) {
          
          this.props.history.push('/viewReimb');
        }
        console.log(res.json())
      })
      // .then(res => res.json())
      // .then(data => { //I have no idea if this part is correct
      //   console.log(data)
      //   this.setState({
      //     User: data
      //   })
        
      // })
      .catch(err => {
        console.log(err);
      })
  }

  submitManager = (e) => {
    e.preventDefault();
    let cred = this.state;
    fetch('http://localhost:8080/project1/users/loginManager', {
      method: 'POST',
      body: JSON.stringify(cred),
      headers: {
        'Content-Type': 'application/json'
      },
      credentials: 'include'
    })
      .then(res => {
        
        if (res.status === 200) {
          
          this.props.history.push('/resolveReimb');
        }
        else 
        {
          alert("You're not a manager!")
        }
        console.log(res.json())
      })

      .catch(err => {
        console.log(err);
      })
  } 

  render() {
    return (
      <>
<div id="row justify-content-center">
      <form className="form-signin" onSubmit={this.submit}>
        <h1 className="h3 mb-3 font-weight-normal">Please sign in</h1>

        <label htmlFor="input-username" className="sr-only">Username</label>
        <input type="text"
          id="input-username"
          className="form-control col-md-auto"
          placeholder="Username"
          required
          value={this.state.username}
          onChange={this.usernameChange}
        />

        <label htmlFor="inputPassword" className="sr-only">Password</label>
        <input type="password"
          id="inputPassword"
          className="form-control col-md-auto"
          placeholder="Password"
          required
          value={this.state.password}
          onChange={this.passwordChange} />

        <button className="btn btn-lg btn-primary btn-block col-md-auto"
          type="submit" onClick={this.submitEmployee}>
          Sign in
        </button>
        <button className="btn btn-lg btn-info btn-block col-md-auto"
          type="submit" onClick={this.submitManager}>
          Sign in as Manager
        </button>

      </form>
      </div >
      </>
    )
  }

}