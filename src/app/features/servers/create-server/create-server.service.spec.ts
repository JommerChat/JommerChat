import { TestBed } from '@angular/core/testing';

import { CreateServerService } from './create-server.service';

describe('CreateServerService', () => {
  let service: CreateServerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateServerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
