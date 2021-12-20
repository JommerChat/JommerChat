import {Member} from './Member';

export interface Messages {
  id: BigInteger;
  createdAt: string;
  attachments?: string[];
  content: string;
  memberEntity: Member;
}
