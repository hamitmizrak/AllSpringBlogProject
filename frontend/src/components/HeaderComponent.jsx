import React, { Component } from "react";

class HeaderComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  render() {
    return (
      <div>
        <header>
          <nav className="navbar navbar-expand-md navbar-primary bg-dark">
            <div>
              <p className="text-center display-4 text-warning">Spring Boot React</p>
            </div>
          </nav>
        </header>
      </div>
    );
  }
}

export default HeaderComponent;
