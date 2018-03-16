import React from 'react'

export function Players({ players, loading }) {

  return (
    <div className="Player-List">
      <h3>Search Results: ({players.length}) {loading && <img src="/ajax-loader.gif" alt="Loader" />}</h3>
      {players.length > 0 && (
        <ul>
          {players.map(player => (
            <li key={player.id} className="Player">
              <figure className="Player-Image"><img src={player.imageUrl} alt="" /></figure>
              <p>{player.name}</p>
            </li>
          ))}
        </ul>
      )}
    </div>
  )
}
