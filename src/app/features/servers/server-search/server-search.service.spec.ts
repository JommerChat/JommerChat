import { TestBed } from '@angular/core/testing';

import { ServerSearchService } from './server-search.service';

describe('ServerSearchService', () => {
  let service: ServerSearchService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServerSearchService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
