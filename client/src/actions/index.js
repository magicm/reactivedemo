export const SEARCHED_PLAYERS_LOADING = 'SEARCHED_PLAYERS_LOADING'
export const SEARCHED_PLAYERS_ERROR = 'SEARCHED_PLAYERS_ERROR'
export const SEARCHED_PLAYERS = 'SEARCHED_PLAYERS'
export const RECEIVED_PLAYERS = 'RECEIVED_PLAYERS'
export const CANCEL_SEARCH = 'CANCEL_SEARCH'

export function cancelSearch() {
  return {
    type: CANCEL_SEARCH,
  }
}

export function searchPlayersError(err) {
  return {
    type: SEARCHED_PLAYERS_ERROR,
    payload: err.message,
  }
}

export function searchPlayersLoading(loading) {
  return {
    type: SEARCHED_PLAYERS_LOADING,
    payload: loading,
  }
}

export function searchPlayers(query) {
  return {
    type: SEARCHED_PLAYERS,
    payload: query,
  }
}

export function receivePlayers(players) {
  return {
    type: RECEIVED_PLAYERS,
    payload: players,
  }
}
