import {Members} from './Members';
import {TextChannel} from './TextChannel';

export interface Messages {
  id: BigInteger;
  createdAt: string;
  content: string;
  memberEntity: Members;
  textChannelEntity: TextChannel;
}
