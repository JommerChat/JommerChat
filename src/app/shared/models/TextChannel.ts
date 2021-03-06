import {Guild} from './Guild';
import {Messages} from './Messages';

export interface TextChannel {
  id: string;
  createdAt: string;
  guildEntity: Guild;
  title: string;
  description?: string;
  categoryId?: string;
  position?: number;
  selected?: boolean;
  messages?: Messages;
}
