import { Observable } from 'rxjs'
import { combineEpics } from 'redux-observable'
import {
  CANCEL_SEARCH,
  receivePlayers,
  SEARCHED_PLAYERS,
  searchPlayersError,
  searchPlayersLoading,
} from '../actions/index'

const apiUrl = `http://localhost:8080/players`
const search = query => `${apiUrl}?q=${encodeURIComponent(query)}`

export function searchPlayersEpic(action$, store, deps) {
  return action$.ofType(SEARCHED_PLAYERS)
    .debounceTime(500, deps.scheduler)
    .filter(action => action.payload !== '')
    .switchMap(({ payload }) => {

      // loading state in UI
      const loading = Observable.of(searchPlayersLoading(true))

      // external API call
      const request = deps.ajax.getJSON(search(payload))
        .takeUntil(action$.ofType(CANCEL_SEARCH))
        .map(receivePlayers)
        .catch(err => {
          return Observable.of(searchPlayersError(err))
        })

      return Observable.concat(
        loading,
        request,
      )
    })
}

export const rootEpic = combineEpics(searchPlayersEpic)

