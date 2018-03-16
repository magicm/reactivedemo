import { Observable } from 'rxjs'
import { VirtualTimeScheduler } from 'rxjs/scheduler/VirtualTimeScheduler'
import { searchPlayers } from '../actions/index'
import { configureStore } from '../configureStore'

it('should perform a search (redux)', function () {

  const scheduler = new VirtualTimeScheduler()
  const deps = {
    scheduler,
    ajax: {
      getJSON: () => Observable.of([{ name: 'shane' }]),
    },
  }

  const store = configureStore(deps)

  const action = searchPlayers('shane')

  store.dispatch(action)

  scheduler.flush()

  expect(store.getState().players.length).toBe(1)
})

