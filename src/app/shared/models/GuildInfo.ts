import {Members} from './Members';
import {TextChannel} from './TextChannel';
import {VoiceChannel} from './VoiceChannel';
import {Messages} from './Messages';

export interface GuildInfo {
  members: Members;
  textChannels: TextChannel[];
  voiceChannels: VoiceChannel[];
  currentTextChannelIndex: number;
  messagesForCurrentChannel: Messages[];
}
