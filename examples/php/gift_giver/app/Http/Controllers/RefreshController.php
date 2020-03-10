<?php

namespace App\Http\Controllers;

use App\Models\Attendee;

class RefreshController extends Controller
{
    const URL = 'https://api.meetup.com/valetechtalks/events/268854460/rsvps?&sign=true&photo-host=public&fields=answers';

    public function index() {
        $participations = json_decode(file_get_contents(self::URL));

        foreach($participations as $participation) {
            $member = $participation->member;
            if(Attendee::where('vendor_member_id', '=', $member->id)->count() == 0) {
                Attendee::create([
                    'name' => $member->name,
                    'vendor_member_id' => $member->id,
                    'languages' => ''
                ]);
            }
        }
    }
}
