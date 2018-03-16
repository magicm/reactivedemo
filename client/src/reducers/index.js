import {
  CANCEL_SEARCH,
  RECEIVED_PLAYERS,
  SEARCHED_PLAYERS,
  SEARCHED_PLAYERS_ERROR,
  SEARCHED_PLAYERS_LOADING,
} from '../actions/index'

const initialState = {
  messages: [],
  players: [],
  loading: false,
}

export function playersReducer(state = initialState, action) {
  switch (action.type) {
    case SEARCHED_PLAYERS_LOADING:
      return {
        ...state,
        loading: action.payload,
      }
    case CANCEL_SEARCH:
      return {
        ...state,
        loading: false,
      }
    case SEARCHED_PLAYERS:
      return {
        ...state,
        messages: [],
      }
    case SEARCHED_PLAYERS_ERROR:
      return {
        ...state,
        loading: false,
        messages: [{ type: 'error', text: action.payload }],
      }
    case RECEIVED_PLAYERS:
      return {
        ...state,
        players: action.payload,
        loading: false,
      }
    default:
      return state
  }
}

export default playersReducer
