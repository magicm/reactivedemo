import React, { Component } from 'react'
import { connect } from 'react-redux'
import './App.css'
import { Players } from './components/Players'
import { Search } from './components/Search'
import { cancelSearch, searchPlayers } from './actions/index'

class App extends Component {

  handlePlayersSearch = query => {
    this.props.searchPlayers(query)
  }

  render() {
    return (
      <div className="App">
        <Search
          defaultValue={''}
          onChange={this.handlePlayersSearch}
          messages={this.props.messages}
          loading={this.props.loading}
          cancel={this.props.cancelSearch}
        />
        <Players players={this.props.players} loading={this.props.loading} />
      </div>
    )
  }
}

export default connect(
  state => state,
  { searchPlayers, cancelSearch },
)(App)
